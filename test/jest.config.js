module.exports = {
  clearMocks: true,
  moduleFileExtensions: ['js', 'ts'],
  modulePaths: ['<rootDir>'],
  setupFiles: ['<rootDir>/jest.setup.js'],
  testEnvironment: 'node',
  testMatch: ['**/*.test.ts'],
  testTimeout: 1000,
  transform: {
    '^.+\\.ts$': 'ts-jest'
  },
  verbose: true
};
