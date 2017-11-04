(ns tim-metcalf.styles
  (:require
    [garden.selectors :as sel]
    [garden.def :refer [defstyles defkeyframes]]))


(def colours {:background "#607D8B"
              :text "#EEE"
              :hover-link "#CCC"})


(defkeyframes fade-left
  [:from {:opacity 0
          :transform "translateX(30px)"}]
  [:to {:opacity 1
        :transform "translateX(0px)"}])

(defkeyframes fade-right
  [:from {:opacity 0
          :transform "translateX(-30px)"}]
  [:to {:opacity 1
        :transform "translateX(0px)"}])


(defkeyframes slide-up
  [:from {:bottom "-20px"}]
  [:to {:bottom "10px"}])


(def link-styles
  [[:a:link {:color (:text colours) :text-decoration "none"}]
  [(sel/a sel/visited) {:color (:text colours) :text-decoration "none"}]
  [(sel/a sel/hover) {:color (:hover-link colours) :text-decoration "none"}]
  [(sel/a sel/active) {:color (:text colours) :text-decoration "none"}]])


(defstyles style
  fade-left
  fade-right
  slide-up
  link-styles

  [:body {:background (:background colours)
          :color (:text colours)
          :font-family "'Raleway', sans-serif"}]
  [:.full-page {:width "100%" :height "100%"}]
  [:.content {:margin "auto" :width "500px" :padding-top "20%"}]
  [:.github {:float "right"
             :opacity 0
             :padding-top "13px"
             :animation fade-right
             :animation-fill-mode "forwards"
             :animation-duration "1s"
             :animation-delay "3s"}
    [sel/hover {:transform "rotateY(360deg)"
                :transition-property "transform"
                :transition-duration "0.8s"
                :transition-timing-function "cubic-bezier(0.82, 0, 0.74, 0.93)"}]]
  [:.heading {:font-size "60px"
              :font-family "'Montserrat', sans-serif"
              :margin-right "80px"
              :opacity 0
              :animation fade-left
              :animation-fill-mode "forwards"
              :animation-duration "1s"
              :animation-delay "1s"}]
  [:.subtitle {:padding-top "20px"
               :font-size "18px"
               :opacity 0
               :animation fade-left
               :animation-fill-mode "forwards"
               :animation-duration "1s"
               :animation-delay "2s"}
    [:.skill-seperator {:padding-left "15px" :padding-right "15px"}]]
  [:.email {:margin-top "20px"
            :opacity 0
            :animation fade-left
            :animation-fill-mode "forwards"
            :animation-duration "1s"
            :animation-delay "2.5s"}]
  [:.source {:font-size "15px"
             :bottom "-20px"
             :position "fixed"
             :right "10px"
             :animation slide-up
             :animation-fill-mode "forwards"
             :animation-duration "0.1s"
             :animation-delay "4s"}])
