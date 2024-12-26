const colors = require('colors');
const dotenv = require('dotenv');
const winston = require('winston');

dotenv.config({ override: true });

winston.loggers.add('project-blind', {
  silent: false,
  transports: [
    new winston.transports.Console({
      prettyPrint: true,
      level: 'debug',
      format: winston.format.combine(
        winston.format.colorize(),
        winston.format.label({ label: 'project-blind' }),
        // eslint-disable-next-line @typescript-eslint/restrict-template-expressions
        winston.format.printf(info => `[${colors.magenta(info.label)}] ${info.level} ${info.message}`)
      )
    })
  ]
});
