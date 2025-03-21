import subprocess


def run_cmd(cmd):
    subprocess.run(cmd, shell=True, check=True)


def run_all():
    run_format()
    run_lint()
    run_tests()


def run_lint():
    run_cmd("poetry run ruff check --fix project_euler")
    run_cmd("poetry run pyright project_euler")


def run_format():
    run_cmd("poetry run black project_euler")
    run_cmd("poetry run isort project_euler")


def run_tests():
     run_cmd("poetry run pytest project_euler")


def run_primes():
    run_cmd("poetry run python project_euler/common/primes.py")
