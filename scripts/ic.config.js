const env = process.argv[process.argv.findIndex(v => v === '--env') + 1];

const config =  {
    apps: [{
        name: 'ic-server',
        script: 'java',
        args: [
            '-jar',
            'bin/inverse-calc-server.jar',
            "-Dlogging.level.tech.tongyu.bct.inversecacl=${IC_LOG_LEVEL:info}",
        ],
        env: {
            BCT_SERVER: 'http://localhost/bct',
            TY_TERMINAL_SERVER: 'https://terminal.tongyu-quant.com',
            TY_TERMINAL_ID: '********',
            TY_TERMINAL_SECRET: '********',
            CALENDARNAME: '默认交易日历'
        },
        env_dev: {
            options: [
                '-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5502',
                '-Dlogging.level.org.hibernate.SQL=debug',
                '-Dlogging.level.org.hibernate.type.descriptor.sql.BasicBinder=trace',
            ],
            IC_API_DOC: true,
            TY_TERMINAL_SERVER: 'https://terminal.tongyu-quant.com',
            TY_TERMINAL_ID: '1635893762352295936',
            TY_TERMINAL_SECRET: 'IdCaoTIPnkDWALYN',
            CALENDARNAME: '回测',
            DUPLICATE_SNOWBALL_API_DOC: true,
            DS_MANAGEMENT: '*',
            DS_MANAGEMENT_HEALTH_SHOW_DETAILS: 'always',
        }
    }]
};
for (const app of config.apps) {
    app.args.unshift(...(app[`env_${env}`]?.options || []))
}

module.exports = config;