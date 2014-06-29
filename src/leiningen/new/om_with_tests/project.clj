(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "{{name}} Om app"
  :url "http://example.com"

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2173"]
                 [prismatic/dommy "0.1.2"]
                 [om "0.6.4"]
                 [prismatic/om-tools "0.2.2"]
                 [sablono "0.2.17"]]

  :plugins [[lein-cljsbuild "1.0.2"]
            [com.cemerick/clojurescript.test "0.3.1"]]

  :source-paths ["src"]

  :cljsbuild {
    :builds [{:id "dev"
              :source-paths ["src"]
              :compiler {:output-to "{{sanitized}}.dev.js"
                         :output-dir "out/dev"
                         :optimizations :none
                         :source-map true}}
             {:id "test"
              :source-paths ["src" "test-cljs"]
              :notify-command ["runners/phantomjs.js"
                               "test-cljs/vendor/es5-shim.js"
                               "test-cljs/vendor/es5-sham.js"
                               "test-cljs/vendor/console-polyfill.js"
                               "resources/private/js/unit-test.js"]
              :compiler {:output-to "resources/private/js/unit-test.js"
                         :output-dir "resources/private/js/"
                         :preamble ["react/react.js"]
                         :externs ["react/externs/react.js"]
                         :optimizations :whitespace}}
             {:id "release"
              :source-paths ["src"]
              :compiler {:output-to "{{sanitized}}.js"
                         :output-dir "out/release"
                         :optimizations :advanced
                         :pretty-print false
                         :preamble ["react/react.min.js"]
                         :externs ["react/externs/react.js"]}}]})
