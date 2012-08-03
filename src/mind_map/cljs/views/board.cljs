(ns mind-map.views.board
  (:require [goog.graphics :as graphics]
            [goog.graphics.ext :as ext]
            [goog.math.Rect :as Rect]
            [mind-map.models.board :as model]
            [domina :as d]))

(def graphics (atom {}))

(defn create [container]
  (render-model (model/new) container))

(defn- render-model [model container]
  (let [canvas (graphics/CanvasGraphics. (model :width ) (model :height ))]
    (.render canvas container)
    (do-seq [node (tree-seq = :children root)]
      (draw-node node canvas))))


(defn- draw-node [node canvas]
  (let [path
        (.modifyBounds
          (get-path (node :size ))
          (get-rect (node :position )))
        stroke (get-stroke)
        fill (get-fill)]
    (.drawPath path stroke fill)))


(def ^:private
  get-path-cache
  (memoize (fn [{height :height width :width}]
             (let [rad 5]
               (-> (ext/Path.)
                 (.moveTo 0 0)
                 (.lineTo (- width rad) 0)
                 (.arcTo rad rad -90 90)
                 (.lineTo width (- height rad))
                 (.arcTo rad rad 0 90)
                 (.lineTo rad height)
                 (.arcTo rad rad 90 90)
                 (.close))))))

(defn- get-path [size]
  (get-path-cache size))

(defn- get-branch [{{root-x :x root-y :y} :position {root-height :height root-width :width} :size} {pos :position size :size}]
  (let [root-y (+ (root-pos :y ) (/ (root-size :height) 2))
        root-left {:x (root-pos :x) :y root-y}
       root-right {:x (+ (root-pos :x) (root-size :x)) :y root-y}
       node-y (+ (node-pos :y) (/ (node-size :height) 2))
        ]
    )


  (let [left
        (> (root-pos :x ) (pos :x ))
        right
        (not left)
        up
        (> (root-pos :y ) (pos :y ))
        down
        (not up)
        begin
        (let
          [y (+ (root-pos :y ) (/ root-size 2))]
          (if left
            {:x (root-pos :x ) :y y}
            {:x (+ (root-pos :x ) (root-sixe :x )) :y y}))
        end
        (let [y (+ (pos :y ) (/ size 2))]
          (if left
            {:x (+ (pos :x ) (sixe :x )) :y y}
            {:x (pos :x ) :y y}))]


    )
  )

(defn- get-rect [{x :x y :y}]
  (Rect. x y 1 1))