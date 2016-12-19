(ns sman.ui
    (:require [seesaw.core :as ss]))

(ss/native!)
(println "native!")

(def f (ss/frame :title "My First Clojure Program!!! with Swing!!! fantastic!!"))

(defn go! [] (-> f ss/pack! ss/show!))