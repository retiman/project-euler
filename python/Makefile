PYTHON ?= $(if $(shell which python3), python3, python)

%: %.py
	PYTHONPATH=lib time ${PYTHON} $<
