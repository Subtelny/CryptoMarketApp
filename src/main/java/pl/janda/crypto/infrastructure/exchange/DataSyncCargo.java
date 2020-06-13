package pl.janda.crypto.infrastructure.exchange;

public abstract class DataSyncCargo<DATA> {

    private DATA data;

    private Long lastSync;

    public DATA getSyncedData() {
        return needSync() ? sync() : data;
    }

    private synchronized DATA sync() {
        this.data = syncData();
        return data;
    }

    private boolean needSync() {
        if (data == null || lastSync == null) {
            return true;
        }
        return System.currentTimeMillis() - lastSync > outdatedEverySeconds() * 1000;
    }

    protected abstract DATA syncData();

    protected abstract int outdatedEverySeconds();

}
