(ns quil-cljx-example.core
	(:require [quil.core :as q])
	#+cljs (:require-macros [quil.core :as q]))

(defn draw []
	(q/background 255)
	(q/fill 0)
	(q/ellipse 56 46 55 55))

(q/defsketch quil-cljx-example
	:draw draw
	:host "quil-cljx-example"
	:size [300 300])

#+clj
(defn -main [])