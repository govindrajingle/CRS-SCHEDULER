package in.cdacnoida.dava.transactions;

import org.springframework.data.jpa.repository.JpaRepository;

import in.cdacnoida.dava.entities.AppUserLogs;

public interface AppUserLogsRepo extends JpaRepository<AppUserLogs, Long> {
	
	
}
