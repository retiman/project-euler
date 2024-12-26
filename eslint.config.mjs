import eslint from '@eslint/js';
import tseslint from 'typescript-eslint';

export default tseslint.config({
  extends: [
    eslint.configs.recommended,
    tseslint.configs.recommended,
  ],
  files: ['**/*.ts'],
  ignores: ['build/**/*', 'dist/**/*', 'node_modules/**/*', '.eslintrc.js', '.prettierrc.js'],
  languageOptions: {
    parserOptions: {
      project: './tsconfig.json',
      tsconfigRootDir: import.meta.dirname,
      ecmaVersion: 2020,
      sourceType: 'module',
    },
  },
  plugins: {
  },
  rules: {
  },
});
