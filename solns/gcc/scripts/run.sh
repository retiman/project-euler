#!/bin/bash
set -e
gcc $1 -o /tmp/soln
/tmp/soln
rm /tmp/soln
