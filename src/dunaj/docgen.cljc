;; Copyright (C) 2013, 2015, Jozef Wagner. All rights reserved.
;;
;; The use and distribution terms for this software are covered by the
;; Eclipse Public License 1.0
;; (http://opensource.org/licenses/eclipse-1.0.php) which can be
;; found in the file epl-v10.html at the root of this distribution.
;;
;; By using this software in any fashion, you are agreeing to be bound
;; by the terms of this license.
;;
;; You must not remove this notice, or any other, from this software.

(ns dunaj.docgen
  "Facilities for generating documentation."
  #?(:dunaj (:api dunaj))
  (:require [dunaj.core :refer [dunaj-ns]]))

(dunaj-ns
 (:require
  [dunaj.doc :refer [gen-doc]]
  [dunaj.repl]
  [foo.core]))

(def dunaj-config
  {:current-version clojure.bootstrap/vc
   :target-path "../dunaj/target/page"
   :examples-path "../dunaj/examples"
   :static-path "../dunaj/doc"
   :disqus "dunajproject"
   :proj-name "Dunaj"
   :proj-url "http://www.dunaj.org"
   :sources-url
   "https://github.com/dunaj-project/dunaj/tree/master/src/clj/"
   :logo-url "dunaj.png"
   :refers-ns 'foo.core
   :core-ns 'dunaj.core
   :copy-years "2013, 2015,"
   :additional-copyright
   "2008, 2015, Rich Hickey and Clojure contributors"
   :authors ["Jozef Wagner"]
   :ns-blacklist #{'dunaj.format.asciidoc 'dunaj.doc 'bare-ws.core}
   :api-header-item "Documentation"
   :ns-regex #"^bare.*|^dunaj.*|^clojure.core"
   :header-menu
   [{:url "about.html" :name "About" :icon :fa-info-circle}
    {:url "news.html" :name "News" :icon :fa-bullhorn}
    {:url "start.html" :name "Getting Started" :icon :fa-download}
    {:url "doc.html" :name "Documentation" :icon :fa-book}
    {:url "https://github.com/dunaj-project"
     :name "Source at Github" :icon :fa-github}]
   :doc-menu
   [{:url "doc.html" :name "Documentation"}
    {:url "rationale.html" :name "Rationale"}
    {:url "guide.html" :name "Crash Course"}
    {:url "spec.html" :name "Specification"}
    {:url "api.html" :name "API"}
    {:url "spi.html" :name "SPI"}
    {:url "todo.html" :name "Future Plans"}]
   :spec-menu
   [{:url "spec.html" :name "Specification"}
    {:url "boolean.html" :name "Booleans"}
    {:url "math.html" :name "Math"}
    {:url "char.html" :name "Characters"}
    {:url "string.html" :name "Strings"}
    {:url "identifier.html" :name "Identifiers"}
    {:url "function.html" :name "Functions"}
    {:url "compare.html" :name "Comparison"}
    {:url "concurrent.html" :name "Concurrency"}
    {:url "reference.html" :name "References"}
    {:url "conventions.html" :name "Conventions"}
    {:url "resources.html" :name "Resources"}
    {:url "metadata.html" :name "Metadata"}
    {:url "types.html" :name "Data types"}]
   :guide-menu
   [{:url "guide.html" :name "Crash Course"}
    {:url "day1.html" :name "Deconstructed API"}
    {:url "day2.html" :name "Type Signatures"}
    {:url "day3.html" :name "Protocols First"}
    {:url "day4.html" :name "Simplified API"}
    {:url "day5.html" :name "Reducers First"}
    {:url "day6.html" :name "Host Performance"}
    {:url "day7.html" :name "Data Formatters"}
    {:url "day8.html" :name "Resources"}
    {:url "day9.html" :name "Improved Math"}
    {:url "day10.html" :name "Documentation"}]
   :static-pages
   [;; main
    ;;{:filename "index"}
    {:filename "about" :name "- About" :section "About" :head "About"}
    {:filename "news" :name "News" :section "News" :head "News"}
    {:filename "start" :name "- Getting Started"
     :section "Getting Started" :head "Getting Started"}
    ;; docs
    {:filename "doc" :name "- Documentation" :menu :doc-menu
     :section "Documentation" :head "Documentation"}
    {:filename "rationale" :name "Design and Rationale"
     :menu :doc-menu :section "Rationale" :head "Documentation"}
    {:filename "guide" :name "crash course"
     :menu :doc-menu :section "Crash Course" :head "Documentation"}
    {:filename "spec" :name "Specification"
     :menu :doc-menu :section "Specification" :head "Documentation"}
    {:filename "todo" :name "- Future Plans" :menu :doc-menu
     :section "Future Plans" :head "Documentation"}
    ;; guide
    {:filename "day1" :name " - Deconstructing Core API"
     :menu :guide-menu :section "Deconstructed API"
     :head "Documentation" :disqus-id "day1"}
    {:filename "day2" :name " - Optional Type Signatures"
     :menu :guide-menu :section "Type Signatures"
     :head "Documentation" :disqus-id "day2"}
    {:filename "day3" :name " - Protocols First"
     :menu :guide-menu :section "Protocols First"
     :head "Documentation" :disqus-id "day3"}
    {:filename "day4" :name " - Towards Simpler API"
     :menu :guide-menu :section "Simplified API"
     :head "Documentation" :disqus-id "day4"}
    {:filename "day5" :name " - Reducers First"
     :menu :guide-menu :section "Reducers First"
     :head "Documentation" :disqus-id "day5"}
    {:filename "day6" :name " - Enabling Host Performance"
     :menu :guide-menu :section "Host Performance"
     :head "Documentation" :disqus-id "day6"}
    {:filename "day7" :name " - Data Formatters"
     :menu :guide-menu :section "Data Formatters"
     :head "Documentation" :disqus-id "day7"}
    {:filename "day8" :name " - Computer And Network Resources"
     :menu :guide-menu :section "Resources"
     :head "Documentation" :disqus-id "day8"}
    {:filename "day9" :name " - Improving Math Facilities"
     :menu :guide-menu :section "Improved Math"
     :head "Documentation" :disqus-id "day9"}
    {:filename "day10" :name " - Captivating Documentation"
     :menu :guide-menu :section "Documentation"
     :head "Documentation" :disqus-id "day10"}
    ;; specs
    {:filename "identifier" :name "- Identifiers" :menu :spec-menu
     :section "Identifiers" :head "Documentation"}
    {:filename "math" :name "- Math" :menu :spec-menu
     :section "Math" :head "Documentation"}
    {:filename "boolean" :name "- Booleans" :menu :spec-menu
     :section "Booleans" :head "Documentation"}
    {:filename "char" :name "- Characters" :menu :spec-menu
     :section "Characters" :head "Documentation"}
    {:filename "string" :name "- Strings" :menu :spec-menu
     :section "Strings" :head "Documentation"}
    {:filename "function" :name "- Functions" :menu :spec-menu
     :section "Functions" :head "Documentation"}
    {:filename "compare" :name "- Comparison" :menu :spec-menu
     :section "Comparison" :head "Documentation"}
    {:filename "reference" :name "- References" :menu :spec-menu
     :section "References" :head "Documentation"}
    {:filename "concurrent" :name "- Concurrency" :menu :spec-menu
     :section "Concurrency" :head "Documentation"}
    {:filename "conventions" :name "- Conventions" :menu :spec-menu
     :section "Conventions" :head "Documentation"}
    {:filename "resources" :name "- Resources" :menu :spec-menu
     :section "Resources" :head "Documentation"}
    {:filename "metadata" :name "- Metadata" :menu :spec-menu
     :section "Metadata" :head "Documentation"}
    {:filename "types" :name "- Data types" :menu :spec-menu
     :section "Data types" :head "Documentation"}
    ]})

(def dunaj-lite-config
  {:current-version clojure.bootstrap/vc
   :target-path "../dunaj/target/page"
   :examples-path "../dunaj/examples"
   :static-path "../dunaj/doc"
   :disqus "dunajproject"
   :proj-name "Dunaj lite"
   :proj-url "http://lite.dunaj.org"
   :sources-url
   "https://github.com/dunaj-project/dunaj/tree/lite/src/clj/"
   :logo-url "dunaj.png"
   :refers-ns 'foo.core
   :core-ns 'dunaj.core
   :copy-years "2013, 2015,"
   :additional-copyright
   "2008, 2015, Rich Hickey and Clojure contributors"
   :authors ["Jozef Wagner"]
   :ns-blacklist #{'dunaj.format.asciidoc 'dunaj.doc 'bare-ws.core}
   :api-header-item "Documentation"
   :ns-regex #"^bare.*|^dunaj.*|^clojure.core"
   :header-menu
   [{:url "http://www.dunaj.org" :name "Dunaj" :icon :fa-home}
    {:url "https://github.com/dunaj-project"
     :name "Source at Github" :icon :fa-github}]
   :doc-menu
   [{:url "doc.html" :name "Documentation"}
    {:url "rationale.html" :name "Rationale"}
    {:url "guide.html" :name "Crash Course"}
    {:url "spec.html" :name "Specification"}
    {:url "api.html" :name "API"}
    {:url "spi.html" :name "SPI"}
    {:url "todo.html" :name "Future Plans"}]
   :spec-menu
   [{:url "spec.html" :name "Specification"}
    {:url "boolean.html" :name "Booleans"}
    {:url "math.html" :name "Math"}
    {:url "char.html" :name "Characters"}
    {:url "string.html" :name "Strings"}
    {:url "identifier.html" :name "Identifiers"}
    {:url "function.html" :name "Functions"}
    {:url "compare.html" :name "Comparison"}
    {:url "concurrent.html" :name "Concurrency"}
    {:url "reference.html" :name "References"}
    {:url "conventions.html" :name "Conventions"}
    {:url "resources.html" :name "Resources"}
    {:url "metadata.html" :name "Metadata"}
    {:url "types.html" :name "Data types"}]
   :guide-menu
   [{:url "guide.html" :name "Crash Course"}
    {:url "day1.html" :name "Deconstructed API"}
    {:url "day2.html" :name "Type Signatures"}
    {:url "day3.html" :name "Protocols First"}
    {:url "day4.html" :name "Simplified API"}
    {:url "day5.html" :name "Reducers First"}
    {:url "day6.html" :name "Host Performance"}
    {:url "day7.html" :name "Data Formatters"}
    {:url "day8.html" :name "Resources"}
    {:url "day9.html" :name "Improved Math"}
    {:url "day10.html" :name "Documentation"}]
   :static-pages
   [;; main
    ;;{:filename "index"}
    {:filename "lite" :name ""}]})

(def pd-config
  {:current-version clojure.bootstrap/vc
   :target-path "../dunaj/target/page"
   :examples-path "../dunaj/examples"
   :static-path "../dunaj/doc"
   :proj-name "Dunaj"
   :disqus "dunajproject"
   :proj-url "http://www.dunaj.org"
   :sources-url
   "https://github.com/dunaj-project/dunaj/tree/master/src/clj/"
   :logo-url "dunaj.png"
   :refers-ns 'foo.core
   :core-ns 'dunaj.core
   :copy-years "2013, 2015,"
   :additional-copyright
   "2008, 2015, Rich Hickey and Clojure contributors"
   :authors ["Jozef Wagner"]
   :ns-blacklist #{'dunaj.format.asciidoc 'dunaj.doc}
   :api-header-item "Documentation"
   :ns-regex #"^bare.*|^dunaj.*|^clojure.core"
   :header-menu
   [{:url "https://github.com/dunaj-project"
     :name "Source at Github" :icon :fa-github}]
   :pd-menu
   [{:url "pday0.html" :name "Introduction"}
    {:url "pday1.html" :name "Deconstructed API"}
    {:url "pday2.html" :name "Type Signatures"}
    {:url "pday3.html" :name "Protocols First"}
    {:url "pday4.html" :name "Simplified API"}
    {:url "pday5.html" :name "Reducers First"}
    {:url "pday6.html" :name "Host Performance"}
    {:url "pday7.html" :name "Data Formatters"}
    {:url "pday8.html" :name "Resources"}
    {:url "pday9.html" :name "Improved Math"}]
   :static-pages
   [{:filename "pday0" :name "Introduction" :menu :pd-menu
     :section "Introduction"}
    {:filename "pday1" :name "- Deconstructing Core API"
     :menu :pd-menu :section "Deconstructed API" :disqus-id "day1"}
    {:filename "pday2" :name "- Optional Type Signatures"
     :menu :pd-menu :section "Type Signatures" :disqus-id "day2"}
    {:filename "pday3" :name "- Protocols First"
     :menu :pd-menu :section "Protocols First" :disqus-id "day3"}
    {:filename "pday4" :name "- Towards Simpler API"
     :menu :pd-menu :section "Simplified API" :disqus-id "day4"}
    {:filename "pday5" :name "- Reducers First"
     :menu :pd-menu :section "Reducers First" :disqus-id "day5"}
    {:filename "pday6" :name "- Enabling Host Performance"
     :menu :pd-menu :section "Host Performance" :disqus-id "day6"}
    {:filename "pday7" :name "- Data Formatters"
     :menu :pd-menu :section "Data Formatters" :disqus-id "day7"}
    {:filename "pday8" :name "- Computer and Network Resources"
     :menu :pd-menu :section "Resources" :disqus-id "day8"}
    {:filename "pday9" :name "- Improving Math Facilities"
     :menu :pd-menu :section "Improved Math" :disqus-id "day9"}]})


;;;; Scratch

(scratch []

  []

  (gen-doc dunaj-config)
 
  (gen-doc dunaj-config true)
  (gen-doc dunaj-config false)
  (gen-doc dunaj-config false 'dunaj.core)
  (gen-doc dunaj-config false 'dunaj.coll)
  (gen-doc dunaj-config false 'dunaj.string)

  (dunaj.doc/gen-api-list dunaj-config true)
  (dunaj.doc/gen-api-list dunaj-config false)

  (dunaj.doc/gen-static dunaj-config)

  (dunaj.doc/gen-static dunaj-lite-config)

  (dunaj.doc/gen-static 
   dunaj-config
   {:filename "news" :name "News" :section "News" :head "News"}
   #_{:filename "start" :name "- Getting Started"
     :section "Getting Started" :head "Getting Started"}
   #_{:filename "doc" :name "- Documentation" :menu :doc-menu
     :section "Documentation" :head "Documentation"}
   #_{:filename "news" :name "News" :section "News" :head "News"}
   #_{:filename "about" :name "- About" :section "About" :head "About"})

  (dunaj.doc/gen-static dunaj-config
    {:filename "day10" :name " - Captivating Documentation"
     :menu :guide-menu :section "Documentation"
     :head "Documentation" :disqus-id "day10"})

  (dunaj.doc/gen-static pd-config)

)
