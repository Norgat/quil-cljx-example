(defproject quil-cljx-example "1.0.0"
  :description "Example of crossplatform Quil sketch"
  :url "https://github.com/Norgat/quil-cljs-example"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
  				      [org.clojars.norgat/quil "2.0.1-SNAPSHOT"]
  				      [org.clojure/clojurescript "0.0-2234"]]

  :plugins [[com.keminglabs/cljx "0.4.0"]
            [lein-cljsbuild "1.0.3"]]
  :hooks [cljx.hooks leiningen.cljsbuild]

  :cljx {:builds [{:source-paths ["src/quil_cljx_example"]
                 :output-path "target/gen/quil_cljx_example"
                 :rules :clj}
                {:source-paths ["src/quil_cljx_example"]
                 :output-path "target/gen/quil_cljx_example"
                 :rules :cljs}]}

  :source-paths ["target/gen"]

  :cljsbuild
  {:builds [{:source-paths ["target/gen"]
             :compiler
             {:output-to "web/js/main.js"
              :externs ["web/js/processing.js"]
              :optimizations :advanced
              :pretty-print false}}]}

  :main quil-cljx-example.core)
