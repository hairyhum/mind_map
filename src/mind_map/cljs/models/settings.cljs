(ns mind-map.models.settings)

(def *default-name* "My map")
(def *default-color*
  "000000")
(def *default-font*
  (map->font
    {:size 12
     :family "Arial"
     :bold false
     :italic false
     :color *default-color*}
    ))
(def *node-size*
  {:width 100
   :height 50})
(def *default-board-size*
  {:width 800
   :height 600})