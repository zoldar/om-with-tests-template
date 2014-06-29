(ns {{name}}.core
  (:require [om.core :as om :include-macros true]
            [{{name}}.components.basic :refer [hello-component]]))

(enable-console-print!)

(defn ^:export init []
  (om/root hello-component
           {:name "Jenny"}
           {:target (.getElementById js/document "{{name}}-app")}))
