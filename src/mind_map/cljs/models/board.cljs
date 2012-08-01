(ns mind-map.models.board
  (:use [mind-map.node :only (node-record node font)]
        [mind-map.models.settings :only (*default-font* *default-color* *default-name* *node-size* *default-board-size*)]))

(def board (atom {}))

(defn new
  ([] (reset-board *default-board-size*))
  ([width height] (reset-board {:width width :height height})))

(defn- reset-board [{:keys [width height] :as size}]
  (reset! board (merge
                  {:root (create-root
                           (get-center width height))}
                  size)))

(defn- create-root [{:keys [x y]}]
  (node
    :text *default-name*
    :position {:x x :y y}
    :font *default-font*
    :color *default-color*))

(defn- get-center [board-width board-height]
  {:x (- (/ board-width 2)
        (/ (*node-size* :width ) 2))
   :y (- (/ board-height 2)
        (/ (*node-size* :height ) 2))})