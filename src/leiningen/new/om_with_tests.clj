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
             ["resources/dev/public/index.html" (render "dev.html" data)]
             ["resources/dev/public/release.html" (render "prod.html" data)]
             ["project.clj" (render "project.clj" data)]
             ["profiles.clj" (render "profiles.clj" data)]
             ["resources/dev/tools/http/ring/server.clj" (render "server.clj" data)]
             ["resources/dev/tools/repl/brepl/connect.cljs" (render "connect.cljs" data)]
             ["README.md" (render "README.md" data)]
             ["LICENSE" (render "LICENSE" data)]
             [".gitignore" (render "gitignore" data)]
             ["runners/phantomjs.js" (render "phantomjs.js" data) :executable true]
             ["src/cljs/{{sanitized}}/core.cljs" (render "core.cljs" data)]
             ["src/cljs/{{sanitized}}/components/basic.cljs" (render "basic.cljs" data)]
             ["resources/test/js/vendor/console-polyfill.js" (render "console-polyfill.js" data)]
             ["resources/test/js/vendor/es5-sham.js" (render "es5-sham.js" data)]
             ["resources/test/js/vendor/es5-shim.js" (render "es5-shim.js" data)]
             ["test/cljs/{{sanitized}}/test.cljs" (render "test.cljs" data)]
             ["test/cljs/{{sanitized}}/components/common_test.cljs" (render "common_test.cljs" data)]
             ["test/cljs/{{sanitized}}/components/basic_test.cljs" (render "basic_test.cljs" data)])))
