(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "{{name}} Om app"
  :url "http://example.com"

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2280"]
                 [prismatic/dommy "0.1.2"]
                 [om "0.7.0"]
                 [sablono "0.2.20"]]
  
  :min-lein-version "2.3.4"

  :plugins [[lein-cljsbuild "1.0.4-SNAPSHOT"]
            [com.cemerick/clojurescript.test "0.3.1"]]
  
  :source-paths ["src/clj" "src/cljs"]

  :test-source-paths ["test/cljs"]

  :cljsbuild {
    :builds {:{{name}}
             {:source-paths ["src/cljs"]
              :compiler 
              {:output-to "resources/dev/public/js/{{sanitized}}.js"
               :output-dir "resources/dev/public/js/"
               :optimizations :advanced
               :pretty-print false
               :preamble ["react/react.min.js"]
               :externs ["react/externs/react.js"]}}}})
