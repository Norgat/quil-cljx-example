(ns quil-cljx-example.core
	(:require [quil.core :as q])
	#+cljs (:require-macros [quil.core :as q]
							[quil.sketch :as sk]))

(def state (atom true))

(defn sketch-start-stop []
	(if @state
		(do
			(reset! state false)
			(q/no-loop))
		(do
			(reset! state true)
			(q/start-loop))))

#+cljs
(defn ^:export switch-sketch-state []
	(sk/with-sketch (q/get-sketch-by-id "quil-cljx-example")
		(sketch-start-stop)))

(defn draw []
	(q/background 255)

	(q/stroke 200 60 5)
	(q/stroke-weight 2)
	(q/line 0 150 (- 300 (mod (q/millis) 300)) 
				  (- 300 (mod (q/millis) 300)))

	(q/stroke 60 50 200)
	(q/stroke-weight 3)
	(q/line (mod (q/millis) 300) (mod (q/millis) 300)
		    300 150))

(q/defsketch quil-cljx-example
	:draw draw
	:host "quil-cljx-example"
	:size [300 300]
	:features [:no-start]
	:mouse-pressed sketch-start-stop)

#+clj
(defn -main [])