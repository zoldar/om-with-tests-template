(ns {{name}}.test.components.basic
  (:require-macros [cemerick.cljs.test :refer (is deftest with-test run-tests testing)])
  (:require [cemerick.cljs.test :as t]
            [dommy.core :as dommy]
            [om.core :as om :include-macros true]
            [{{name}}.test.components.common :as com]
            [{{name}}.components.basic :as basic])
  (:use-macros [dommy.macros :only [node sel sel1]]))

(deftest hello-renders?
  (testing "Hello component renders correctly."
    (let [hello-name "Joe"
          container (com/new-container!)
          data {:name hello-name}]
      (om/root basic/hello-component data {:target container})
      (is (= (str "Hello, " hello-name "!")
             (dommy/text (sel1 container :.message)))))))
