#lang racket

(provide string-drop
         string-take)

(define (string-drop n s)
  ((compose list->string
            (curryr drop n)
            string->list) s))

(define (string-take n s)
  ((compose list->string
            (curryr take n)
            string->list) s))
