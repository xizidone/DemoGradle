-- 调整回测记录数据格式
UPDATE duplicate_snowball.backtest_record SET result = concat('{"data": ', "result", '}')::json
WHERE json_typeof("result") = json_typeof('[]') ;