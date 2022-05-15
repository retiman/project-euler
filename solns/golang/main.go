package main

import "os"
import "github.com/retiman/project-euler/pkg/problems"

var ps map[string]interface{}

func init() {
  ps = map[string]interface{}{
    "1": problems.P1,
  }
}

func main() {
  key := os.Args[1]
  p := ps[key]
  p.(func())()
}
