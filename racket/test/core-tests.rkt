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

    (check-equal? (integer->char-list 1) '(#\1) "1 as char list")
    (check-equal? (integer->char-list 123) '(#\1 #\2 #\3) "123 as char list")

    (check-equal? (integer->list 1) '(1) "1 as list")
    (check-equal? (integer->list 123) '(1 2 3) "123 as list")

    (check-equal? (char-list->integer '(#\1)) 1 "1 from char list")
    (check-equal? (char-list->integer '(#\1 #\2 #\3)) 123 "123 from char list")

    (check-equal? (list->integer '(1)) 1 "1 from list")
    (check-equal? (list->integer '(1 2 3)) 123 "123 from list")

    (test-case
      "two lists can be zipped"
      (let* ((xs '(a b c d))
             (ys '(1 2 3 4)))
        (check-equal? (zip xs ys) '((a 1) (b 2) (c 3) (d 4)))))

    (test-case
      "three lists can be zipped"
      (let* ((xs '(a b c d))
             (ys '(1 2 3 4))
             (zs '(x y z w)))
        (check-equal? (zip xs ys zs)
                      '((a 1 x) (b 2 y) (c 3 z) (d 4 w)))))

    (test-case
      "two lists can be zipped into a map"
      (let* ((xs '(a b c d))
             (ys '(1 2 3 4)))
        (check-equal? (zipmap xs ys) (hash 'a 1 'b 2 'c 3 'd 4))))))
