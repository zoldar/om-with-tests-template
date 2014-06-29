(ns {{name}}.components.basic
  (:require [om-tools.core :refer-macros [defcomponent]]
            [schema.core :as s]
            [sablono.core :as html :refer-macros [html]]))

(defcomponent hello-component [{:keys [name]} owner]
  (render
   [_]
   (html [:div.message (str "Hello, " name "!")])))
