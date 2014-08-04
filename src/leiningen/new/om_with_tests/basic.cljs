(ns {{name}}.components.basic
  (:require [om.core :as om :include-macros true]
            [sablono.core :as html :refer-macros [html]]))

(defn hello-component 
  [{:keys [name]} owner]
  (reify
    om/IRender
    (render
      [_]
      (html [:div.message (str "Hello, " name "!")]))))
