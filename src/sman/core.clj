(ns sman.core
  (:gen-class)
  (:require [sman.ui :as ui]))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (do 
    (println "HELLo Younghwan")
    (ui/go!)))
