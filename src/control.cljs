(ns quil-cljx-example.control
	(:require [quil.core :as q])
	(:require-macros [quil.core :as q]
					 [quil.sketch :as sk]))

(def state (atom true))

(defn ^:export switch-sketch-state []
	(sk/with-sketch (q/get-sketch-by-id "quil-control")
		(if @state
			(do
				(reset! state false)
				(q/background 90 102 0)
				(q/no-loop))
			(do
				(reset! state true)
				(q/start-loop)))))

(defn draw []
	(q/background 255)
	(q/fill 0)
	(q/ellipse 56 46 55 55))

(q/defsketch control
	:draw draw
	:host "quil-control"
	:size [300 300])