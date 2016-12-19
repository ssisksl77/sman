(ns sman.ui
    (:require [seesaw.core :as ss]))

(ss/native!)

(def f (ss/frame
         :title "switch into csv for email. deadliy useful."
         :size [500 :by 300]
         :on-close :exit))

(defn display [content]
  (ss/config! f :content content) content)


(display (ss/border-panel
          :north (ss/horizontal-panel :items ["name: " (ss/label :text "Younghwan Name") "   email: " (ss/label :text "ssisksl77@gmail.com")])
          :center (ss/left-right-split (ss/scrollable (ss/button :text "switch -> csv")) (ss/scrollable (ss/text :multi-line? true :text "right-label\nhello world")))
           ))


(defn go! [] (-> f ss/pack! ss/show!))
