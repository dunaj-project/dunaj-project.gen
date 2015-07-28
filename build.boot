;; Copyright (C) 2015, Jozef Wagner. All rights reserved.

(set-env!
 :resource-paths #{"src"}
 :dependencies '[[org.dunaj/dunaj.doc "0.7.0"]
                 [org.dunaj/dunaj "0.7.0"]])

(require 'dunaj.doc)
(require 'dunaj.docgen)
(require 'clojure.java.io)

(deftask compile-docs []
  (with-pre-wrap fileset
    (clojure.java.io/make-parents
     (str (:target-path dunaj.docgen/dunaj-config) "/foo"))
    (dunaj.doc/gen-doc dunaj.docgen/dunaj-config)
    fileset))
