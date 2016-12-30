(ns sman.ui
    (:require [seesaw.core :as ss]
              [seesaw.chooser :as choose]))

(ss/native!)

(def f (ss/frame
         :title "MAGIC STRING"
         :minimum-size [500 :by 300]
         ;:on-close :exit
         :icon (clojure.java.io/resource "yhnam.png")))
(defn display
  ([content] (ss/config! f :content content) content)
  ([where content] (ss/config! where :text content)))


(def c-pan-textarea (ss/text :multi-line? true :text ""))


(def n-pan (ss/horizontal-panel :items
  ["name: " (ss/label :text "Younghwan Name")
   "   email: " (ss/label :text "ssisksl77@gmail.com")
   (ss/button :text "open.txt" :listen [:action (fn [event] (choose/choose-file :success-fn (fn [fc file] (display c-pan-textarea file))))])]))

(def c-pan (ss/left-right-split
  (ss/scrollable (ss/button
                  :text "get email"
                  :listen [:action (fn [event] (display c-pan-textarea
                    (reduce str (interpose ", " (filter #(re-matches #".+\@.+\..+" %) (clojure.string/split (ss/text c-pan-textarea) #"\n"))))))]))
  (ss/scrollable c-pan-textarea )))

(def s-pan "south")

(display (ss/border-panel
          :north n-pan
          :center c-pan
          :south s-pan ))
(defn go! [] (-> f ss/pack! ss/show!))
