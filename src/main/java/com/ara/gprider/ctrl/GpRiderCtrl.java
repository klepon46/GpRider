package com.ara.gprider.ctrl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.Binder;
import org.zkoss.bind.sys.Binding;
import org.zkoss.image.AImage;
import org.zkoss.util.media.Media;
import org.zkoss.zhtml.Li;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Button;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Image;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Vlayout;

import com.ara.gprider.bean.GpRider;
import com.ara.gprider.service.GpRiderService;

public class GpRiderCtrl extends GenericForwardComposer{

	private static final long serialVersionUID = 1L;
	
	private Image gambar;
	
	private Textbox tbRiderName;
	private Textbox tbRiderBike;
	private Textbox tbRiderNumber;
	private Listbox lbRider;
	
	private Button btnUpload;
	private Button btnSave;
	private Button btnAdd;
	
	GpRiderService gpRiderService;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		gpRiderService = (GpRiderService) SpringUtil.getBean("gpRider");
		disableComp();
		refreshList();
	}
	
	public void onClick$btnSave() {
		GpRider gpRider = new GpRider();
		gpRider.setRiderName(tbRiderName.getValue());
		gpRider.setRiderBike(tbRiderBike.getValue());
		gpRider.setRiderNumber(tbRiderNumber.getValue());
		gpRider.setRiderPhoto(gambar.getContent().getByteData());
		gpRiderService.save(gpRider);
		
		disableComp();
		refreshList();
		
	}
	
	
	public void onUpload$btnUpload(UploadEvent event){
		
		Media media = event.getMedia();
		if(media instanceof org.zkoss.image.Image){
			org.zkoss.image.Image img = (org.zkoss.image.Image) media;
			gambar.setContent(img);
		}else{
			alert("File yang diupload harus berfomat *.JPG");
			return;
		}
	}
	
	public void onClick$btnAdd(){
		tbRiderName.setDisabled(false);
		tbRiderBike.setDisabled(false);
		tbRiderNumber.setDisabled(false);
		btnUpload.setDisabled(false);
		btnSave.setDisabled(false);
	}
	
	public void disableComp(){
		tbRiderName.setDisabled(true);
		tbRiderBike.setDisabled(true);
		tbRiderNumber.setDisabled(true);
		btnUpload.setDisabled(true);
		btnSave.setDisabled(true);
	}
	
	public void refreshList(){
		
		List<GpRider> lists = gpRiderService.findAll();
		lbRider.setModel(new ListModelList(lists));
		lbRider.setItemRenderer(new ListitemRenderer() {

			public void render(Listitem item, Object data, int arg2)
					throws Exception {
				
				GpRider gpRider = (GpRider) data;
				item.setValue(gpRider);
				
				new Listcell(gpRider.getRiderName()).setParent(item);
				new Listcell(gpRider.getRiderBike()).setParent(item);
				new Listcell(gpRider.getRiderNumber()).setParent(item);
			}
		});
	}
	
	public void getImage(String name) throws IOException{
		GpRider gpRider = gpRiderService.findByName("Rossi");
		BufferedImage bi = null;
		ByteArrayInputStream bais = new ByteArrayInputStream(gpRider.getRiderPhoto());
		bi = ImageIO.read(bais);
		gambar.setContent(bi);
	}
	
	public void onSelect$lbRider() throws IOException{
		
		Listbox box = (Listbox) lbRider.getFellow("win").getFellow("lbRider");
		List<Listitem> listItem = box.getItems();
		
		for(Listitem currentRow : listItem){
			List<Component> com = currentRow.getChildren();
			for(Component currentCom : com){
				Listcell lc = (Listcell) currentCom;
				if(lc.getColumnIndex()== 0){
					tbRiderName.setValue(lc.getLabel());
					getImage(lc.getLabel());
					
				}
				if(lc.getColumnIndex() == 1){
					tbRiderBike.setValue(lc.getLabel());
				}
				if(lc.getColumnIndex() == 2){
					tbRiderNumber.setValue(lc.getLabel());
				}
			}
		}
	}
}
