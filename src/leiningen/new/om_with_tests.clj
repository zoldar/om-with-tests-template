(ns leiningen.new.om-with-tests
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files year]]
            [leiningen.core.main :as main]))

(def render (renderer "om-with-tests"))

(defn om-with-tests
  "A lein template for creating Om project along with auto test setup."
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)
              :year (year)}]
    (main/info (str "Generating fresh 'lein new' project named " name " based on om-with-tests template."))
    (->files data
             ["dev.html" (render "dev.html" data)]
             ["prod.html" (render "prod.html" data)]
             ["project.clj" (render "project.clj" data)]
             ["README.md" (render "README.md" data)]
             ["LICENSE" (render "LICENSE" data)]
             [".gitignore" (render "gitignore" data)]
             ["runners/phantomjs.js" (render "phantomjs.js" data) :executable true]
             ["src/{{sanitized}}/core.cljs" (render "core.cljs" data)]
             ["src/{{sanitized}}/components/basic.cljs" (render "basic.cljs" data)]
             ["test-cljs/vendor/console-polyfill.js" (render "console-polyfill.js" data)]
             ["test-cljs/vendor/es5-sham.js" (render "es5-sham.js" data)]
             ["test-cljs/vendor/es5-shim.js" (render "es5-shim.js" data)]
             ["test-cljs/{{sanitized}}/test.cljs" (render "test.cljs" data)]
             ["test-cljs/{{sanitized}}/components/common.cljs" (render "common.cljs" data)]
             ["test-cljs/{{sanitized}}/components/basic.cljs" (render "basic_test.cljs" data)])))
