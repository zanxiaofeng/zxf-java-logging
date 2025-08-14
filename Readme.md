# SLF4j Based Java Logging Pattern
- Abstract & Implementation Split Pattern
- Bridge Pattern

# 日志：
- 每一个独立的Call In（Controller, Message）要记录entering，exiting，exception日志
- 每一个独立的Call Out也要记录request，response，exception日志
- 每一个独立的流程入口（Task，Thread，Event，PostConstruct）要记录entering，exiting，exception日志
- 每一个重要的分支要记录entering，exiting，exception日志
- 日志一定要记录caseＩd以及相关上下文信息
- 只使用slf４j记录日志

# 结构化表达
- 采用层级展开结构表达
- Title， subTitle和Value分开
- 数值量可以采用%展示占比