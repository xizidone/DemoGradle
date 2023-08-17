CREATE SCHEMA IF NOT EXISTS duplicate_snowball;

CREATE TABLE IF not exists duplicate_snowball.backtest_record (
               id int8 NOT NULL,
               created_at timestamp NULL,
               created_by varchar(255) NULL,
               updated_at timestamp NULL,
               updated_by varchar(255) NULL,
               "version" int4 NULL,
               data_scope varchar(255) NULL,
               hedging_instrument_id varchar(255) NULL,
               instrument_id varchar(255) NULL,
               "name" varchar(255) NULL,
               product_type varchar(255) NULL,
               remark varchar(255) NULL,
               request json NULL,
               "result" json NULL,
               view_content varchar(65535) NULL,
               CONSTRAINT backtest_record_pkey PRIMARY KEY (id)
);
COMMENT ON TABLE duplicate_snowball.backtest_record IS '回测记录';

COMMENT ON COLUMN duplicate_snowball.backtest_record.id IS 'ID';
COMMENT ON COLUMN duplicate_snowball.backtest_record.data_scope IS '数据范围';
COMMENT ON COLUMN duplicate_snowball.backtest_record.hedging_instrument_id IS '对冲合约';
COMMENT ON COLUMN duplicate_snowball.backtest_record.instrument_id IS '标的物代码';
COMMENT ON COLUMN duplicate_snowball.backtest_record.name IS '名字';
COMMENT ON COLUMN duplicate_snowball.backtest_record.product_type IS '结构类型';
COMMENT ON COLUMN duplicate_snowball.backtest_record.remark IS '备注信息';
COMMENT ON COLUMN duplicate_snowball.backtest_record.request IS '回测参数';
COMMENT ON COLUMN duplicate_snowball.backtest_record.result IS '回测结果';
COMMENT ON COLUMN duplicate_snowball.backtest_record.view_content IS '视图内容';

COMMENT ON COLUMN duplicate_snowball.backtest_record.version IS '记录版本';
COMMENT ON COLUMN duplicate_snowball.backtest_record.created_at IS '创建时间';
COMMENT ON COLUMN duplicate_snowball.backtest_record.created_by IS '创建用户';
COMMENT ON COLUMN duplicate_snowball.backtest_record.updated_at IS '更新时间';
COMMENT ON COLUMN duplicate_snowball.backtest_record.updated_by IS '更新用户';



UPDATE duplicate_snowball.backtest_record SET data_scope='PUBLIC' WHERE data_scope is null;
