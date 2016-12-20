(ns sman.ui
    (:require [seesaw.core :as ss]))

(ss/native!)

(def f (ss/frame
         :title "MAGIC STRING"
         :minimum-size [500 :by 300]
         :on-close :exit
         :icon (clojure.java.io/resource "yhnam.png")))

(defn display [content]
  (ss/config! f :content content) content)

(def n-pan (ss/horizontal-panel :items
  ["name: " (ss/label :text "Younghwan Name")
   "   email: " (ss/label :text "ssisksl77@gmail.com")
   (ss/button :text "open .txt")]))

(def c-pan (ss/left-right-split (ss/scrollable (ss/button :text "get email")) (ss/scrollable (ss/text :multi-line? true :text ""))))

(def s-pan "south")

(display (ss/border-panel
          :north n-pan
          :center c-pan
          :south s-pan ))

(defn go! [] (-> f ss/pack! ss/show!))
