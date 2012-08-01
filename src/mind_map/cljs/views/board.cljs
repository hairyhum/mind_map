(ns mind-map.views.board
  (:require [goog.graphics :as graphics]
            [goog.graphics.ext :as ext]
            [goog.graphics.CanvasGraphics :as canvas]
            [mind-map.models.board :as model]
            [domina :as d]))

(def graphics (atom {}))

(defn create [container]
  (render-model (model/new) container))

(defn- render-model [model container]
  (let [canvas (graphics/CanvasGraphics. (model :width ) (model :height ))]
    (do-seq [node (tree-seq = :children root)]
      (draw-node node canvas))))

(defn- draw-node [node canvas]
  )


(defun get-path []
  (let [height (*node-size* :height )
        width (*node-size* :width )
        rad 5]
    (-> (ext/Path.)
      (.moveTo 0 0)
      (.lineTo (- width rad) 0)
      (.arcTo rad rad -90 90)
      (.lineTo width (- height rad))
      (.arcTo rad rad 0 90)
      (.lineTo rad height)
      (.arcTo rad rad 90 90)
      (.close)
      )))