(ns mind-map.node
  "Node model. Builds in node tree")

(defprotocol Node
  (root? [node] "Checks if node is root")
  (add [node child] "Adds new child to node")
  (remove [node child] "Removes child from node"))

(defrecord node-record
  [parent
   text
   position
   size
   font
   color
   children]
  Node
  (root? [_]
    (nil? parent))
  (add [node child]
    (assoc node :children (conj children child)))
  (remove [node child]
    (assoc node :children (desj children child))))

(defn node [& {:keys [parent text position size font color children]}]
  (atom (map->node-record
          {:parent parent
           :text text
           :position position
           :size size
           :font font
           :color color
           :children (set children)}
          )))

(defrecord font [size family bold italic color])



