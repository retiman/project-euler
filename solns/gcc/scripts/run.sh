#!/bin/bash
set -e
gcc "$@" -o /tmp/soln
/tmp/soln
rm /tmp/soln
