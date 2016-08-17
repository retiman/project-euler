#lang racket

(provide core-tests)

(require rackunit)
(require "../lib/core.rkt")

(define core-tests
  (test-suite
    "Tests for core.rkt"

    (check-equal? (char->integer* #\0) 0 "convert 0 char")
    (check-equal? (char->integer* #\1) 1 "convert 1 char")
    (check-equal? (char->integer* #\9) 9 "convert 9 char")
    (check-equal? (char->integer* #\A) #f "does not convert A char")

    (check-equal? (distinct '(1 2 2))
                  (remove-duplicates '(1 2 2))
                  "distinct is exported")
    (test-case
      "immutable hashes can be merged"
      (let* ((a (hash 'a 1 'b 2))
             (b (hash 'c 3 'd 4))
             (c (hash-merge a b)))
        (check-equal? (hash-ref c 'a) 1)
        (check-equal? (hash-ref c 'b) 2)
        (check-equal? (hash-ref c 'c) 3)
        (check-equal? (hash-ref c 'd) 4)))

    (test-case
      "immutable hashes can be merged with keys being overridden"
      (let* ((a (hash 'a 1 'b 2))
             (b (hash 'b 3 'd 4))
             (c (hash-merge a b)))
        (check-equal? (hash-ref c 'a) 1)
        (check-equal? (hash-ref c 'b) 3)
        (check-equal? (hash-ref c 'd) 4)))

    (test-case
      "mutable hashes can be merged"
      (let* ((a (make-hash (list '(a . 1) '(b . 2))))
             (b (make-hash (list '(c . 3) '(d . 4)))))
        (hash-merge! a b)
        (check-equal? (hash-ref a 'a) 1)
        (check-equal? (hash-ref a 'b) 2)
        (check-equal? (hash-ref a 'c) 3)
        (check-equal? (hash-ref a 'd) 4)))

    (test-case
      "mutable hashes can be merged with keys being overridden"
      (let* ((a (make-hash (list '(a . 1) '(b . 2))))
             (b (make-hash (list '(b . 3) '(d . 4)))))
        (hash-merge! a b)
        (check-equal? (hash-ref a 'a) 1)
        (check-equal? (hash-ref a 'b) 3)
        (check-equal? (hash-ref a 'd) 4)))
))
