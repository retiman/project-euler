#lang racket

(provide set-tests)

(require rackunit)
(require "../lib/set.rkt")

(define set-tests
  (test-suite
    "Tests for set.rkt"

    (check-equal? (set-filter even? (set 1 2 3 4 5 6)) (set 2 4 6)
                  "test set filter")

    (check-equal? (set-length (set)) 0 "set length of 0")
    (check-equal? (set-length (set 1)) 1 "set length of 1")))
