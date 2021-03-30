#lang racket
(provide string-tests)
(require rackunit)
(require "string.rkt")


(define string-tests
  (test-suite
    "Tests for string.rkt"

    (check-equal? (string-drop 0 "hello") "hello" "drop 0 chars from hello")
    (check-equal? (string-drop 2 "hello") "llo" "drop 2 chars from hello")
    (check-equal? (string-drop 5 "hello") "" "drop 5 chars from hello")
    (check-equal? (string-drop 6 "hello") "" "drop 6 chars from hello")
    (check-equal? (string-drop 0 "") "" "drop 0 chars from ''")
    (check-equal? (string-drop 1 "") "" "drop 1 chars from ''")

    (check-equal? (string-take 0 "hello") "" "take 0 chars from hello")
    (check-equal? (string-take 2 "hello") "he" "take 2 chars from hello")
    (check-equal? (string-take 5 "hello") "hello" "take 5 chars from hello")
    (check-equal? (string-take 6 "hello") "hello" "take 6 chars from hello")
    (check-equal? (string-take 0 "") "" "take 0 chars from ''")
    (check-equal? (string-take 1 "") "" "take 1 chars from ''")))
