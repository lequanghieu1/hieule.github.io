package Weapon.Service.User;

import org.springframework.stereotype.Service;

import Weapon.Dto.PaginatesDto;

@Service
public interface iPaginatesService {
public PaginatesDto GetInfoPaginates(int totalData,int limit,int currentPage);

}
