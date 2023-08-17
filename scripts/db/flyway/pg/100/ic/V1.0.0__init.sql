CREATE SCHEMA IF NOT EXISTS inverse_calc_service;

CREATE TABLE IF not exists inverse_calc_service.ic_history_record(
    id int8 NOT NULL,
    name VARCHAR(255),
    data_scope VARCHAR(255),
    instrument_id VARCHAR(255),
    ic_request VARCHAR,
    ic_response VARCHAR,
    note VARCHAR(255),
    version int4,
    created_at TIMESTAMP,
    created_by VARCHAR(255),
    updated_at TIMESTAMP,
    updated_by VARCHAR(255),
    PRIMARY KEY (id)
);

COMMENT ON TABLE inverse_calc_service.ic_history_record IS '反算历史';
COMMENT ON COLUMN inverse_calc_service.ic_history_record.id IS 'ID';
COMMENT ON COLUMN inverse_calc_service.ic_history_record.name IS '名字';
COMMENT ON COLUMN inverse_calc_service.ic_history_record.data_scope IS '数据范围';
COMMENT ON COLUMN inverse_calc_service.ic_history_record.instrument_id IS '标的物代码';
COMMENT ON COLUMN inverse_calc_service.ic_history_record.ic_request IS '请求值';
COMMENT ON COLUMN inverse_calc_service.ic_history_record.ic_response IS '请求结果';
COMMENT ON COLUMN inverse_calc_service.ic_history_record.version IS '记录版本';
COMMENT ON COLUMN inverse_calc_service.ic_history_record.created_at IS '创建时间';
COMMENT ON COLUMN inverse_calc_service.ic_history_record.created_by IS '创建用户';
COMMENT ON COLUMN inverse_calc_service.ic_history_record.updated_at IS '更新时间';
COMMENT ON COLUMN inverse_calc_service.ic_history_record.updated_by IS '更新用户';


