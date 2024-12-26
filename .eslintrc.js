module.exports = {
  extends: [
    'airbnb-base',
    'airbnb-typescript/base',
    // Disables rules that are handled by prettier already.
    //
    // See https://github.com/prettier/eslint-config-prettier
    'prettier'
  ],
  parserOptions: {
    project: './tsconfig.json'
  },
  plugins: ['@typescript-eslint', 'jest', 'unused-imports'],
  rules: {
    '@typescript-eslint/explicit-function-return-type': 'off',
    '@typescript-eslint/explicit-module-boundary-types': 'off',
    // Permits the violation of naming conventions for unused variables with a leading underscore.
    //
    // See https://typescript-eslint.io/rules/naming-convention/
    '@typescript-eslint/naming-convention': [
      'error',
      {
        selector: 'variable',
        format: ['camelCase', 'PascalCase', 'snake_case'],
        leadingUnderscore: 'allow',
        modifiers: ['unused']
      },
      {
        selector: 'parameter',
        format: ['camelCase', 'PascalCase', 'snake_case'],
        leadingUnderscore: 'allow'
      }
    ],
    // Enabled because one should not assign the result of a void function.
    //
    // See https://typescript-eslint.io/rules/no-confusing-void-expression/
    '@typescript-eslint/no-confusing-void-expression': 'error',
    '@typescript-eslint/no-meaningless-void-operator': 'error',
    // Enabled because no-shadow reports spurious errors in TypeScript sometimes.
    '@typescript-eslint/no-shadow': 'error',
    '@typescript-eslint/no-unused-expressions': 'error',
    '@typescript-eslint/no-unused-vars': 'off',
    '@typescript-eslint/no-useless-constructor': 'error',
    '@typescript-eslint/no-use-before-define': 'off',
    '@typescript-eslint/no-var-requires': 'off',
    // Disabled because there's no reason to enable this except to be pedantic.  Code organization desires may dictate
    // that methods not using this should still be methods.  For example, there are situations where it's desirable to
    // define only instance methods for ease of use, or you would prefer that the caller not have to know or care that
    // a method actually uses instance variables or not.
    //
    // In other situations, nothing is stopping you from declaring a function outside of a class, which is functionally
    // the same as a static method.
    //
    // See https://eslint.org/docs/latest/rules/class-methods-use-this
    'class-methods-use-this': 'off',
    // Disabled because this rule cannot detect if a dependency is only for development.  For example, if you have a
    // postbuild.js and you include it in tsconfig.json, then this plugin will incorrectly assume that any packages
    // required there should be in dependencies.
    //
    // In that situation, postbuild.js is included in tsconfig.json so that JavaScript files (even ones not included
    // in the final build) should be linted according to @typescript-eslint.
    //
    // See https://stackoverflow.com/questions/61956555/why-is-typescript-eslint-parser-including-files-outside-of-those-configured-in
    // See https://www.typescriptlang.org/tsconfig#include
    'import/no-extraneous-dependencies': 'off',
    // Disabled because named exports are more explicit.
    //
    // See https://github.com/airbnb/javascript/issues/1365
    // See https://blog.neufund.org/why-we-have-banned-default-exports-and-you-should-do-the-same-d51fdc2cf2ad
    'import/prefer-default-export': 'off',
    'jest/no-disabled-tests': 'off',
    'max-classes-per-file': 'off',
    // Disabled because continue ESLint specifically is concerned about continue being used with labels.  Using this
    // with labels is akin to a goto statement, which makes code hard to reason about.  Proper use of the continue
    // statement makes code easier to read.
    //
    // The ESLint recommendations around avoiding continue involve using if statements, which do actively degrade code
    // readability.  ESLint, for whatever reason, recommends this even when labels are not required.  Good readability,
    // in contrast, would call for using continue statements with guard clauses.
    //
    // See https://eslint.org/docs/latest/rules/no-continue
    // See https://refactoring.com/catalog/replaceNestedConditionalWithGuardClauses.html
    'no-continue': 'off',
    // Disabled because prettier can fix this.
    'no-irregular-whitespace': 'off',
    // Disabled because it is handled by @typescript-eslint rules.
    'no-shadow': 'off',
    // Disabled for convenience.  Enable again if this ends up hurting the project.
    //
    // See https://eslint.org/docs/latest/rules/no-plusplus
    'no-plusplus': 'off',
    'no-restricted-syntax': [
      'error',
      {
        selector: 'ForInStatement',
        message: 'for..in loops iterate over the prototype chain, which is virtually never what you want'
      },
      {
        selector: 'LabeledStatement',
        message: 'labels are a form of goto; using them makes code confusing and hard to maintain'
      },
      {
        selector: 'WithStatement',
        message: 'with is disallowed in strict mode because it makes code impossible to predict and optimize'
      }
    ],
    // Disabled because we do want to have underscore prefixed identifiers to indicate a variable is ignored.
    //
    // See https://eslint.org/docs/latest/rules/no-underscore-dangle
    'no-underscore-dangle': 'off',
    'no-unused-expressions': 'off',
    'no-unused-vars': 'off',
    'no-use-before-define': 'off',
    'no-useless-constructor': 'off',
    // Disabled because `let [a] = arr;` or `[a] = arr` is just silly sometimes.
    //
    // See https://eslint.org/docs/latest/rules/prefer-destructuring
    'prefer-destructuring': [
      'error',
      {
        object: false,
        array: false
      }
    ],
    'unused-imports/no-unused-imports': 'error',
    'unused-imports/no-unused-vars': [
      'warn',
      {
        args: 'all',
        argsIgnorePattern: '^_',
        caughtErrorsIgnorePattern: '^_',
        vars: 'all',
        varsIgnorePattern: '^_'
      }
    ],
    // Enabled because it is useful for some problems.  ESLint disables this by default because it assumes that a single
    // & or | is a mistyped && or ||.
    //
    // See https://eslint.org/docs/latest/rules/no-bitwise
    'no-bitwise': 'off',
    // Disabled because some solutions can be implemented more naturally with a while (true) loop.
    'no-constant-condition': 'off',
    // Disabled because some solutions run more optimally if you do mutate the inputs.  This will trigger even if you
    // reassign a field in an object, which makes it more convenient if turned off.
    'no-param-reassign': 'off'
  },
  ignorePatterns: ['build', 'coverage', 'dist', 'node_modules']
};
