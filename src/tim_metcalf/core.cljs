(ns tim-metcalf.core
    (:require [reagent.core :as r]))

(enable-console-print!)


(def skills ["Clojure" "Python" "Ansible"])


(defn heading []
  [:div.heading "Tim Metcalf"])


(defn subtitle []
  (->> skills
    (map #(vec [[:span %] [:span.skill-seperator "•"]]))
    (mapcat identity)
    butlast
    (into [:div.subtitle])))


(defn github []
  [:div.github
   [:a {:href "https://github.com/Prodge"}
    [:img {:src "img/github-mark.svg"}]]])


(defn email []
  [:div.email
    [:a {:href "mailto:tim@tim-metcalf.com?subject=Enquiry"}
        "tim@tim-metcalf.com"]])


(defn source []
  [:a.source {:href "https://github.com/Prodge"} "Source"])


(defn home []
  [:div.full-page
    [:div.content
      [github]
      [heading]
      [subtitle]
      [email]
      [source]]])


(defn reload []
  (r/render [home]
            (.getElementById js/document "app")))


(defn ^:export main []
  (reload))


(defn on-js-reload []
  (reload))
