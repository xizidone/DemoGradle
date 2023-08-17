
CREATE TABLE IF not exists duplicate_snowball.contract_info (
               id int8 NOT NULL,
               created_at timestamp NULL,
               created_by varchar(255) NULL,
               updated_at timestamp NULL,
               updated_by varchar(255) NULL,
               "version" int4 NULL,
               contract_id varchar(255) NULL,
               contract_multiplier numeric(19,2) NULL,
               contract_name varchar(255) NULL,
               instrument_id varchar(255) NULL,
               CONSTRAINT contract_info_pkey PRIMARY KEY (id)
);


INSERT INTO duplicate_snowball.contract_info
(id, created_at, created_by, updated_at, updated_by, "version", instrument_id, contract_id, contract_name, contract_multiplier)
VALUES(426993953949340686, now(), NULL, NULL, NULL, NULL, '000905.SH', 'IC0', '中证500主力', 200)
ON CONFLICT (id) DO NOTHING;

INSERT INTO duplicate_snowball.contract_info
(id, created_at, created_by, updated_at, updated_by, "version", instrument_id, contract_id, contract_name, contract_multiplier)
VALUES(426993953949340687, now(), NULL, NULL, NULL, NULL, '000852.SH', 'IM0', '中证1000主力', 200)
ON CONFLICT (id) DO NOTHING;

INSERT INTO duplicate_snowball.contract_info
(id, created_at, created_by, updated_at, updated_by, "version", instrument_id, contract_id, contract_name, contract_multiplier)
VALUES(426993953949340688, now(), NULL, NULL, NULL, NULL, '000300.SH', 'IF0', '沪深300主力', 300)
ON CONFLICT (id) DO NOTHING;

INSERT INTO duplicate_snowball.contract_info
(id, created_at, created_by, updated_at, updated_by, "version", instrument_id, contract_id, contract_name, contract_multiplier)
VALUES(426993953949340689, now(), NULL, NULL, NULL, NULL, '000016.SH', 'IH0', '上证50主力', 300)
ON CONFLICT (id) DO NOTHING;