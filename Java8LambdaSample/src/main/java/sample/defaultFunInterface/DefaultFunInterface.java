package sample.defaultFunInterface;

public interface DefaultFunInterface {
	// 定义默认方法 count
	default int count() {
		return 1;
	}
}
