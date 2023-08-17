//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package tech.tongyu.bct.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Schema(
    description = "交易日历"
)
@JsonInclude(Include.NON_EMPTY)
public class TradingCalendarDTO{
    @Schema(
        description = "交易日历代码，仅用于标识 DEFAULT_CALENDAR"
    )
    private String calendarId;
    @Schema(
        description = "交易日历名称"
    )
    private @NotBlank(
    message = "交易日历名称不能为空"
) String calendarName;
    @Schema(
        description = "是否默认选项"
    )
    private Boolean defaultFlag;
    @Schema(
        description = "非交易日列表"
    )
    private List<Holiday> holidays;
    @Schema(
        description = "交易日列表"
    )
    private List<BusinessDay> businessDays;

    public TradingCalendarDTO() {
    }

    public String getCalendarId() {
        return this.calendarId;
    }

    public String getCalendarName() {
        return this.calendarName;
    }

    public Boolean getDefaultFlag() {
        return this.defaultFlag;
    }

    public List<Holiday> getHolidays() {
        return this.holidays;
    }

    public List<BusinessDay> getBusinessDays() {
        return this.businessDays;
    }

    public void setCalendarId(final String calendarId) {
        this.calendarId = calendarId;
    }

    public void setCalendarName(final String calendarName) {
        this.calendarName = calendarName;
    }

    public void setDefaultFlag(final Boolean defaultFlag) {
        this.defaultFlag = defaultFlag;
    }

    public void setHolidays(final List<Holiday> holidays) {
        this.holidays = holidays;
    }

    public void setBusinessDays(final List<BusinessDay> businessDays) {
        this.businessDays = businessDays;
    }

    @Schema(
        description = "交易日"
    )
    public static class BusinessDay implements Serializable {
        @Schema(
            description = "记录 ID"
        )
        @JsonSerialize(
            using = ToStringSerializer.class
        )
        private Long id;
        @Schema(
            description = "交易日日期"
        )
        private LocalDate businessDay;
        @Schema(
            description = "备注"
        )
        private String note;

        public Long getId() {
            return this.id;
        }

        public LocalDate getBusinessDay() {
            return this.businessDay;
        }

        public String getNote() {
            return this.note;
        }

        public void setId(final Long id) {
            this.id = id;
        }

        public void setBusinessDay(final LocalDate businessDay) {
            this.businessDay = businessDay;
        }

        public void setNote(final String note) {
            this.note = note;
        }

        public BusinessDay() {
        }

        public BusinessDay(final Long id, final LocalDate businessDay, final String note) {
            this.id = id;
            this.businessDay = businessDay;
            this.note = note;
        }
    }

    @Schema(
        description = "非交易日"
    )
    public static class Holiday implements Serializable {
        @Schema(
            description = "记录 ID"
        )
        @JsonSerialize(
            using = ToStringSerializer.class
        )
        private Long id;
        @Schema(
            description = "非交易日日期"
        )
        private LocalDate holiday;
        @Schema(
            description = "备注"
        )
        private String note;

        public Long getId() {
            return this.id;
        }

        public LocalDate getHoliday() {
            return this.holiday;
        }

        public String getNote() {
            return this.note;
        }

        public void setId(final Long id) {
            this.id = id;
        }

        public void setHoliday(final LocalDate holiday) {
            this.holiday = holiday;
        }

        public void setNote(final String note) {
            this.note = note;
        }

        public Holiday() {
        }

        public Holiday(final Long id, final LocalDate holiday, final String note) {
            this.id = id;
            this.holiday = holiday;
            this.note = note;
        }
    }
}
