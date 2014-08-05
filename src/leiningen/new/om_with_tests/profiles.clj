{:shared {:clean-targets ["out" :target-path]}

 :tdd [:shared 
       {:cljsbuild
        {:builds {:{{name}}
                  {:source-paths ["test/cljs"]
                   :notify-command ["runners/phantomjs.js"
                                    "resources/test/js/vendor/es5-shim.js"
                                    "resources/test/js/vendor/es5-sham.js"
                                    "resources/test/js/vendor/console-polyfill.js"
                                    "resources/test/js/unit-test.js"]
                   :compiler {:output-to "resources/test/js/unit-test.js"
                              :output-dir "resources/test/js/"
                              :optimizations :whitespace}}}}}]
 
  :dev [:shared
       {:resource-paths ["resources/dev"]
        :source-paths ["resources/dev/tools/http" "resources/dev/tools/repl"]
        :dependencies [[ring "1.2.1"]
                       [compojure "1.1.6"]
                       [hickory "0.5.3"]]
        :plugins [[com.cemerick/austin "0.1.4"]]
        :cljsbuild
        {:builds {:{{name}}
                  {:source-paths ["resources/dev/tools/repl"]
                   :compiler
                   {:output-to "resources/dev/public/js/{{sanitized}}.dev.js"
                    :output-dir "resources/dev/public/js/"
                    :optimizations :none
                    :source-map "resources/dev/public/js/{{sanitized}}.dev.js.map"
                    :pretty-print true}}}}
        :injections [(require '[ring.server :as http :refer [run]]
                              'cemerick.austin.repls)
                     (defn browser-repl-env []
                       (reset! cemerick.austin.repls/browser-repl-env
                               (cemerick.austin/repl-env)))
                     (defn browser-repl []
                       (cemerick.austin.repls/cljs-repl
                         (browser-repl-env)))]}]}
