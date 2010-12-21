/*****************************************************************************
 *                                McPAT
 *                      SOFTWARE LICENSE AGREEMENT
 *            Copyright 2009 Hewlett-Packard Development Company, L.P.
 *                          All Rights Reserved
 *
 * Permission to use, copy, and modify this software and its documentation is
 * hereby granted only under the following terms and conditions.  Both the
 * above copyright notice and this permission notice must appear in all copies
 * of the software, derivative works or modified versions, and any portions
 * thereof, and both notices must appear in supporting documentation.
 *
 * Any User of the software ("User"), by accessing and using it, agrees to the
 * terms and conditions set forth herein, and hereby grants back to Hewlett-
 * Packard Development Company, L.P. and its affiliated companies ("HP") a
 * non-exclusive, unrestricted, royalty-free right and license to copy,
 * modify, distribute copies, create derivate works and publicly display and
 * use, any changes, modifications, enhancements or extensions made to the
 * software by User, including but not limited to those affording
 * compatibility with other hardware or software, but excluding pre-existing
 * software applications that may incorporate the software.  User further
 * agrees to use its best efforts to inform HP of any such changes,
 * modifications, enhancements or extensions.
 *
 * Correspondence should be provided to HP at:
 *
 * Director of Intellectual Property Licensing
 * Office of Strategy and Technology
 * Hewlett-Packard Company
 * 1501 Page Mill Road
 * Palo Alto, California  94304
 *
 * The software may be further distributed by User (but not offered for
 * sale or transferred for compensation) to third parties, under the
 * condition that such third parties agree to abide by the terms and
 * conditions of this license.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" WITH ANY AND ALL ERRORS AND DEFECTS
 * AND USER ACKNOWLEDGES THAT THE SOFTWARE MAY CONTAIN ERRORS AND DEFECTS.
 * HP DISCLAIMS ALL WARRANTIES WITH REGARD TO THE SOFTWARE, INCLUDING ALL
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS.   IN NO EVENT SHALL
 * HP BE LIABLE FOR ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES
 * OR ANY DAMAGES WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS,
 * WHETHER IN AN ACTION OF CONTRACT, NEGLIGENCE OR OTHER ACTION, ARISING
 * OUT OF OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THE SOFTWARE.
 *
 ***************************************************************************/

#include "io.h"
#include "parameter.h"
#include "array.h"
#include "const.h"
#include "logic.h"
#include "basic_circuit.h"
#include "arbiter.h"
#include <string.h>
#include <iostream>
#include <algorithm>
#include "XML_Parse.h"
#include <string.h>
#include <cmath>
#include <assert.h>
#include "spm.h"

SPM::SPM(ParseXML *XML_interface, int ithSpm_, InputParameter* interface_ip_)
:XML(XML_interface),
 ithSpm(ithSpm_),
 interface_ip(*interface_ip_)
{
  int idx;
  int tag, data;
  bool is_default, debug;

  double size, line, assoc, banks;

  debug           = false;
  is_default=true;//indication for default setup


  size                             = spmp.capacity;
  line                             = spmp.blockW;

  interface_ip.specific_tag        = 0;
  interface_ip.tag_w               = 0;
  interface_ip.cache_sz            = (int)size;
  interface_ip.line_sz             = (int)line;
  interface_ip.assoc               = 0;
  interface_ip.nbanks              = 0;
  interface_ip.out_w               = interface_ip.line_sz;
  interface_ip.access_mode         = 1;
  interface_ip.throughput          = spmp.throughput;
  interface_ip.latency             = spmp.latency;
  interface_ip.is_cache			 = false;
  interface_ip.pure_ram			 = true;
  interface_ip.pure_cam          = false;
  interface_ip.obj_func_dyn_energy = 0;
  interface_ip.obj_func_dyn_power  = 0;
  interface_ip.obj_func_leak_power = 0;
  interface_ip.obj_func_cycle_t    = 1;
  interface_ip.num_rw_ports        = 1;//lower level cache usually has one port.
  interface_ip.num_rd_ports        = 0;
  interface_ip.num_wr_ports        = 0;
  interface_ip.num_se_rd_ports     = 0;
  interface_ip.force_cache_config  =false;
}

void SPM::computeEnergy(bool is_tdp)
{
	unispm.spms->stats_t.readAc.access  = unispm.spms->l_ip.num_search_ports*spmp.duty_cycle;
	unispm.spms->stats_t.readAc.miss    = 0;
	unispm.spms->stats_t.readAc.hit     = unispm.spms->stats_t.readAc.access - unispm.spms->stats_t.readAc.miss;
	unispm.spms->stats_t.writeAc.access = 0;
	unispm.spms->stats_t.writeAc.miss   = 0;
	unispm.spms->stats_t.writeAc.hit    = unispm.spms->stats_t.writeAc.access -	unispm.spms->stats_t.writeAc.miss;
	unispm.spms->tdp_stats = unispm.spms->stats_t;

	unispm.power_t.reset();

	unispm.power = unispm.power_t + (unispm.spms->local_result.power)*pppm_lkg;
	power     = power + unispm.power;
}

void SPM::displayEnergy(uint32_t indent,bool is_tdp)
{
	string indent_str(indent, ' ');
	string indent_str_next(indent+2, ' ');
	bool long_channel = XML->sys.longer_channel_device;

	if (is_tdp)
	{
		cout << (XML->sys.number_spms > 0? indent_str:"")<< spmp.name << endl;
		cout << indent_str << "Area = " << area.get_area()*1e-6<< " mm^2" << endl;
		//cout << indent_str << "Peak Dynamic = " << power.readOp.dynamic*spmp.clockRate << " W" << endl;
		cout << indent_str << "Subthreshold Leakage = "
			<< (long_channel? power.readOp.longer_channel_leakage:power.readOp.leakage) <<" W" << endl;
		//cout << indent_str << "Subthreshold Leakage = " << power.readOp.longer_channel_leakage <<" W" << endl;
		cout << indent_str << "Gate Leakage = " << power.readOp.gate_leakage << " W" << endl;
		//cout << indent_str << "Runtime Dynamic = " << rt_power.readOp.dynamic/spmp.executionTime << " W" << endl;
		cout <<endl;
	}
}

void SPM::set_spm_param()
{
	spmp.name = "SPM";
	interface_ip.data_arr_ram_cell_tech_type    = 1;
	interface_ip.data_arr_peri_global_tech_type = 1;
	interface_ip.tag_arr_ram_cell_tech_type     = 1;
	interface_ip.tag_arr_peri_global_tech_type  = 1;
	spmp.capacity      = 64;
	spmp.blockW        = 4;
	spmp.throughput    = 4;
	spmp.latency       = 1;
	spmp.duty_cycle    = 1;

//	spmp.name = "SPM";
//	interface_ip.data_arr_ram_cell_tech_type    = XML->sys.spm[ithSpm].device_type;//long channel device LSTP
//	interface_ip.data_arr_peri_global_tech_type = XML->sys.spm[ithSpm].device_type;
//	interface_ip.tag_arr_ram_cell_tech_type     = XML->sys.spm[ithSpm].device_type;
//	interface_ip.tag_arr_peri_global_tech_type  = XML->sys.spm[ithSpm].device_type;
//	spmp.capacity      = XML->sys.spm[ithSpm].L2_config[0];
//	spmp.blockW        = XML->sys.spm[ithSpm].L2_config[1];
//	spmp.throughput    = XML->sys.spm[ithSpm].L2_config[4]/spmp.clockRate;
//	spmp.latency       = XML->sys.spm[ithSpm].L2_config[5]/spmp.clockRate;
//	spmp.duty_cycle    = XML->sys.spm[ithSpm].duty_cycle;
}

