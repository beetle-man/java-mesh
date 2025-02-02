/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.javamesh.sample.servermonitor.command;

import com.huawei.javamesh.sample.servermonitor.common.Constant;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 执行指令：cat /proc/diskstats
 * <p>文档地址: <a href=https://www.kernel.org/doc/Documentation/ABI/testing/procfs-diskstats>Document</a></p>
 */
public class DiskCommand extends CommonMonitorCommand<List<DiskCommand.DiskStats>> {

    private static final String COMMAND = "cat /proc/diskstats";

    private static final int DEVICE_NAME_INDEX = 3;
    private static final int SECTORS_READ_INDEX = 6;
    private static final int SECTORS_WRITTEN_INDEX = 10;
    private static final int IO_SPENT_MILLIS_INDEX = 13;

    @Override
    public String getCommand() {
        return COMMAND;
    }

    /**
     * 重构泛PaaS类：com.huawei.apm.plugin.collection.util.DiskParser parse方法
     */
    @Override
    public List<DiskStats> parseResult(InputStream inputStream) {
        final List<String> lines = readLines(inputStream);
        final List<DiskStats> diskStats = new ArrayList<DiskStats>(lines.size());
        for (String line : lines) {
            String[] diskStatsText = line.split(Constant.REGEX_MULTI_SPACES);
            String deviceName = diskStatsText[DEVICE_NAME_INDEX];
            long sectorsRead = Long.parseLong(diskStatsText[SECTORS_READ_INDEX]);
            long sectorWritten = Long.parseLong(diskStatsText[SECTORS_WRITTEN_INDEX]);
            long ioSpentMillis = Long.parseLong(diskStatsText[IO_SPENT_MILLIS_INDEX]);
            diskStats.add(new DiskStats(deviceName, sectorsRead, sectorWritten, ioSpentMillis));
        }
        return diskStats;
    }

    public static final class DiskStats {
        /**
         * 3. Device name
         */
        private final String deviceName;

        /**
         * 6. Number of sectors read. This is the total number of sectors read successfully.
         */
        private final long sectorsRead;

        /**
         * 10. Number of sectors written. This is the total number of sectors written successfully.
         */
        private final long sectorsWritten;

        /**
         * 13. Number of milliseconds spent doing I/Os. This field is increased so long as field 9 is nonzero.
         */
        private final long ioSpentMillis;

        public DiskStats(String deviceName, long sectorsRead, long sectorsWritten, long ioSpentMillis) {
            this.deviceName = deviceName;
            this.sectorsRead = sectorsRead;
            this.sectorsWritten = sectorsWritten;
            this.ioSpentMillis = ioSpentMillis;
        }

        public String getDeviceName() {
            return deviceName;
        }

        public long getSectorsRead() {
            return sectorsRead;
        }

        public long getSectorsWritten() {
            return sectorsWritten;
        }

        public long getIoSpentMillis() {
            return ioSpentMillis;
        }
    }
}
